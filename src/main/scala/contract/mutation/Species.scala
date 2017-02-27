package stem.contract.mutation

/**
 * This Trait represents the spieces (type) of a given program. Spieces are
 * unique across the whole Stem topology to designate mutation, not mutation
 * instances.
 * @author mdemarne (mdemarne@outlook.com)
 */
trait Species {
  // Unique identifier of te spiece. This is stored as a string.
  val id: String
  // TODO: figure out versioning.
}
