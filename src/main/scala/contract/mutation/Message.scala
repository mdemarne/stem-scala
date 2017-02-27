package stem.contract.mutation

/**
 * This Trait represents a message exchanged between Mutations over Stem
 * actors.
 * TODO: figure out if this is needed. I suppose it is, but it will require
 * much more information than what's currently in there.
 * @author mdemarne (mdemarne@outlook.com)
 */
trait Message {
  /** Species from which this message is sent. */
  val from: Species
  /** Species to which this message is sent. */
  val to: Species
}
