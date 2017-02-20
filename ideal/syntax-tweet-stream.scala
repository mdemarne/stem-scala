/**
 * THIS FILE WILL NEVER COMPILE.
 * It is just there to illustrate what Stem could look like if we were to
 * aggregate tweets in real-time.
 * @author mdemarne (mdemarne@outlook.com)
 */

import stem

// 1. Establish the Stem topology.
// We specify that we want the StemTopology to be elastic. This means that
// if needed, more cells will be created by the topology. Other modes include
// static, meaning that only a given pool of cells will be created. If all
// cells in the domain are mutated, then the Topology will refuse to mutate
// new cells.

val topology = new StemTopology(policy = StemPolicy.Elastic)

// 2. This has nothing to do with Stem. We simply set some parameters.

// List of tags to follow.
val tags = "Sailing" :: "Corsica" :: "Greece" :: "sailboat" :: Nil

// List of author to follow.
val authors = "me" :: "you" :: Nil

// 3. Creating and loading all mutations
// All mutations are here defined as simple functions. Meaning that they do
// not require more dependencies. This is just an example for simplicity -
// in a real-world application, these functions could be replaced by
// pointers to .jars to be shipped over the network, such that any Stem cell
// around the globe could get the proper dependencies and load them at runtime.

// Will get tweets for a given tag. The function will block on the firehose
// until a tweet is returned.
def sourceMutation(tag: String) = () => ??? // TODO Stuff

// Will count the number of characters in a tweet
val charCounterMutation = (tweet: String) => tweet.length
}
// Will count the number of characters per author, per tweet. For the sake of
// the example, we want one cell per author. In a later version, we could
// imagine each cell doing an expensive operation, which would require
// them to be parallelized. It takes the given author in parameter.
// Note that None will not be sent.
def authorCharCounterMutation(author : String) = (tweet: String) =>
    if (tweet.contains(author)) Some((author, tweet.length)) else None

// Will aggregate results and send them out to a callback function. As this
// has internal variable, it is defined as a case class.
case class AggregateMutation() extends Stem.Program {
  var total = 0
  var totalPerAuthor = Map[String, Int]()
  def apply(length: Int) = {
    total += length
    (total, totalPerAuthor)
  }
  def apply(author: String, length: Int) = {
    totalPerAuthor.get(author) match {
      case None => totalPerAuthor += (author -> length)
      case Some(tot) => totalPerAuthor += (author -> (length + tot))
    }
    (total, totalPerAuthor)
  }
}

// Simple callback function. Prints the results. This will not be a mutation
// in a stem cell.
def callback(total: Int, totalPerAuthor: Map[String, Int]) {
  println(s"Total tweets: $total")
  println(s"Per author: $totalPerAuthor")
}

// 4. We can now acquire cells and mutate them.

// For all sources.
val sources = tags.map { tag =>
  topology.acquire.mutate(sourceMutation(tag))
}

// A single cell counting everything.
val charCounter = topology.acquire.mutate(charCounterMutation).consume(sources)

// One counter per author.
val authorCharCounters = authors.map { author =>
  topology.acquire.mutate(authorCharCounterMutation(author)).consume(sources)
}

// And one aggregator.
val aggregator = topology.acquire.mutate(AggregateMutation)
  .consume(charCounter).consume(authorCharCounters)

// 5. We can now register the callback function.

topology.acquire.mutate(Stem.AsyncCall(callback)).consume(aggregator)

// 6. We can now send a tick message to the sources, such that they iterate
// forever. Note that this only works if the mutation does not take any
// parameter.

source ! Stem.Loop

// 6. Enjoy the results being printed!

/*
 * 1. In case of failure, the topology handles the restarts.
 * 2. Each mutation is actually a function that consume specific message types.
 * Those functions are defined
 */
