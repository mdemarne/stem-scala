package stem.contract.cell
import stem.contract._

/**
 * This Trait represents the logic to store and load mutations locally
 * in a Stem Actor.
 * @author mdemarne (mdemarne@outlook.com)
 */
trait Store {
  /*** Save a given mutation based on its unique identity. */
  def save(program: mutation.Program): Unit
  /** fetches a given mutation based o nits unique identity. */
  def fetch(id: mutation.Identity): Option[mutation.Program]
}
