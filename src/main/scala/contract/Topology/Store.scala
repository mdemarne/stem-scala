package stem.contract.topology
import stem.contract._

/**
 * This Trait represents the logic to store and load mutations locally in a
 * topology.
 * @author mdemarne (mdemarne@outlook.com)
 */
trait Store {
  /** Save a given mutation based on its unique species. */
  def save(program: mutation.Seed): Unit
  /** Fetches a given mutation based on its unique species. */
  def fetch(sp: mutation.Species): Option[mutation.Seed]
  /** Checks whenever the local topology store contains a given mutation or
   * not. */
  def contains(sp: mutation.Species): Boolean
}
