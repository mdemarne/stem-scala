/**
 * THIS FILE WILL NEVER COMPILE. It is just there to illustrate what Stem
 * could look like if we were to aggregate tweets in real-time.
 * @author mdemarne (mdemarne@outlook.com)
 */

// 1. Establish the Stem topology.
// We specify that we want the StemTopology to be elastic. This means that
// if needed, more cells will be created by the topology. Other modes include
// static, meaning that only a given pool of cells will be created. If all
// cells in the domain are mutated, then the Topology will refuse to mutate
// new cells.
val topology = new StemTopology(policy = StemPolicy.Elastic)

// 2. Set WGNG specific settings, load sources, program types
val wgngParams = Params(w = 2 min, 1 min)
  .setCorrelationThreshold(0.7)
  .setMaxHistory(3 days)
  // ...

val sources = ??? // Akka stream of sources
def splitterMutation(???) = ??? // A function representing a splitter
def analyzerMutation(???) = ??? // A function representing an analyzer
def reporterMutation(???) = ??? // A function representing a reporter

def callback(???) = ??? // Callback function

// 3. Create the number of required splitters
val splitters = sources.map { src =>
  topology.acquire.mutate(splitterMutation).consume(src)
}

/// 4. Creating the number of analyzer instances
val analyzers = splitters.map { splitter =>
  topology.acquire.mutate(analyzerMutation).consume(splitter)
}

// 5. Creating the reporter
val reporter = topology.acquire.mutate(reporterMutation).consumeAll(analyzers)

// 6. Creating a placeholder for reporter for asynchronous call.
val cb = topology.acquire.mutate(Stem.AsyncCall(callback)).consume(reporter)

/*
 * 1. In case of failure, the topology handles the restarts
 * 2. Each mutation is actually a function that consume specific message types.
 *   => We want to be able to receive more than one message type however.
 *   => Need to look at typed Actors
 */
