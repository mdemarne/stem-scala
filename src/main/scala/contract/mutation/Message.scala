package stem.contract.mutation

/**
 * This Trait represents a message exchanged between Mutations over Stem
 * actors.
 * @author mdemarne (mdemarne@outlook.com)
 */
trait Message {
  /** Identity from which this message is sent. */
  val from: Identity
  /** Identity to which this message is sent. */
  val to: Identity
}
