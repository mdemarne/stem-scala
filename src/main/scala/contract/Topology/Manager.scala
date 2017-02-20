package stem.contract.topology
import stem.contract._

import scala.util.Try

/**
 * This Trait represents the logic to manage the Stem Topology.
 * @author mdemarne (mdemarne@outlook.com)
 */
trait Manager {
  /** Tentatively acquire a cell in the topology. */
  def acquire: Try[cell.Executor with cell.Loader]
  /** Release a cell belonging to the topology. This always successes. */
  def release(cll: cell.Executor with cell.Loader): Unit
}
