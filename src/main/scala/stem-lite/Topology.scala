package stemLite
import stem._

import scala.util.Try

/**
 * Implementation of a topology. This is the high-level object used to create,
 * generate, deploy stem actors with tasks
 * @author mdemarne (mdemarne@outlook.com)
 */
class Topology(policy: contract.topology.Policy.Value)
  extends contract.topology.Store
  with contract.topology.Manager {

  /* Internal variables */

  /** Actor System associated with the topology */
  val system: akka.actor.ActorSystem = akka.actor.ActorSystem.create("stem")

  /** Pool of stem cell currently available */
  private var freeCells = policy match {
    // If the topology is elastic, we do not warm up the pool.
    case contract.topology.Policy.Elastic =>
      Set[Cell]()
    // If the topology is static, we warm up the pool.
    case contract.topology.Policy.Static(nbCells) =>
      (0 until nbCells).map(_ => new Cell).toSet
  }

  /** Pool of stem cell currently used */
  private var usedCells = Set[Cell]()

  /* Store implementation */

  def save(program: contract.mutation.Seed): Unit = ???
  def fetch(sp: contract.mutation.Species): Option[contract.mutation.Seed] = ???
  def contains(sp: contract.mutation.Species): Boolean = ???

  /* Manager implementation */

  def acquire: Try[Cell] = ???
  def release(cll: contract.cell.Executor with contract.cell.Loader): Unit = ???
}
