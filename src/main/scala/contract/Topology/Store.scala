package stem.contract.topology
import stem.contract._

/**
 * This Trait represents the logic to store and load mutations locally in a
 * topology.
 * @author mdemarne (mdemarne@outlook.com)
 */
trait Store {
  /** Save a given mutation based on its unique spieces. */
  def save(program: mutation.Seed): Unit
  /** Fetches a given mutation based on its unique spieces. */
  def fetch(sp: mutation.Spieces): Option[mutation.Seed]
  /** Checks whenever the local topology store contains a given mutation or
   * not. */
  def contains(sp: mutation.Spieces): Boolean
}
