package stem.contract.mutation

/**
 * This Trait represents the implementation of a specific program represented
 * by a given mutation.
 * @author mdemarne (mdemarne@outlook.com)
 */
trait Program {
  /** Represents the spieces of the given program. */
  val spieces: Spieces
  /** Represents the original seed of the given program. */
  val seed: Seed
}
