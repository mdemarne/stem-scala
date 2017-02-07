package stem.contract.cell
import stem.contract._

import scala.util.Try

/**
 * This Trait represents the logic load mutations at runtime in a Stem Actor.
 *
 * @author mdemarne (mdemarne@outlook.com)
 */
trait Loader {
  /** Loads a given mutation seed, transforms it into a program. */
  def load(seed: mutation.Seed): Try[mutation.Program]
}
