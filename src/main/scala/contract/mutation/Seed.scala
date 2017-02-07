package stem.contract.mutation

/**
 * This Trait represents a seed of a program for a given mutation. Seeds are
 * exchanged at runtime to let Stem Actors load programs never seen before.
 * @author mdemarne (mdemarne@outlook.com)
 */
trait Seed {
  /** Represents the identity of the given seed. Identities are unique. */
  val identity: Identity
}
