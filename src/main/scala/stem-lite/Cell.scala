package stemLite
import stem._

import scala.util.Try

/**
 * Implementation of a generic Stem Cell.
 * @author mdemarne (mdemarne@outlook.com)
 */
class Cell extends stem.contract.cell.Executor
           with    stem.contract.cell.Loader
           with    stem.contract.cell.Replication
           with    akka.actor.Actor {

  /* Executor implementation */

  def mutate(sp: contract.mutation.Program): Boolean = ???
  def revert: contract.mutation.Species = ???

  /* Loader implementation */

  def load(seed: contract.mutation.Seed): Try[contract.mutation.Program] = ???
  def load(sp: contract.mutation.Species): Try[contract.mutation.Program] = ???

  /* Actor-model function */

  def receive = ???
}
