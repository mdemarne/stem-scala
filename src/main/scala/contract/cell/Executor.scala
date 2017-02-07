package stem.contract.cell
import stem.contract._

/**
 * This Trait represents the logic to execute programs in a Stem Actor.
 * @author mdemarne (mdemarne@outlook.com)
 */
trait Executor {
  /** Transforms the current Stem actor into a program of a specific mutation
    * type. Returns True on success, False otherwise. */
  def mutate(sp: mutation.Program): Boolean
  /** Rever the current mutation. The old mutation is restored, and the
    * Spieces of the restored mutation is returned. */
  def revert: mutation.Spieces
}
