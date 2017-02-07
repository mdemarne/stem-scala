package stem.contract.mutation

/**
 * This Trait represents a message exchanged between Mutations over Stem
 * actors.
 * @author mdemarne (mdemarne@outlook.com)
 */
trait Message {
  /** Spieces from which this message is sent. */
  val from: Spieces
  /** Spieces to which this message is sent. */
  val to: Spieces
}
