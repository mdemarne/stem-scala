package stem.contract.cell
import stem.contract._

/**
 * This Trait represents the logic to store and load mutations locally in a
 * Stem Actor.
 * @author mdemarne (mdemarne@outlook.com)
 */
trait Store {
  /** Save a given mutation based on its unique spieces. */
  def save(program: mutation.Seed): Unit
  /** fetches a given mutation based on its unique spieces. */
  def fetch(sp: mutation.Spieces): Option[mutation.Seed]
}
