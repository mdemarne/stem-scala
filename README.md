# Scala-based Implementation of the Stem Middleware for Nanoservices

**There is a ton to do here**. But first, let's have a quick description of what the Stem Middleware aims to be. This is the **north star**!

## It's like biology

Stem cells can be transformed in anything. In some cases, they can also revert to their original state and be transformed again to have another functionality.

The Stem middleware inspires itself from biology to do the exact same thing. It leverages the power of the Actor Model and its streaming capability to deploy *nanoservices* that can be transformed at someone's need and reverted. Ship your code as a simple message to a Stem actor, and it will execute it for you.

But there is more.

Stem aims to be fully reactive and resilient. Its decentralized topology is governed by a leader-election process. For each Stem topology, the leader ensures load balancing. It also discusses with other leaders. And if a Stem actor dies, it ensures that it has previously be cloned, and that it can be re-created with minimal downtime.

## A cloud for everyone

You have many machines and you want to be able to leverage their capabilities without worrying about installing software or deploying applications? Your friend agrees to give you a small part of memory on her or his home server? You do not want to pay to have your always-on application running on the cloud of a big provider? Stem aims to solve this. Deploy it on any machine connected to internet and let it communicate with the external world. And once you know what to do with it, simply chip your code to it through messaging, instruct it of your application's topology, and let it do its job!

## Caveat

Why **nanoservices**? Because each Stem cell is represented by an **actor**. Meaning a small, sequential executor, that only communicates with his peers using message-passing. It is smaller than a *microservice* in the sense that a microservice executes a task but can be a far more complex system on its own. With Stem, you get more, but smaller, components.

Embrace the Actor Model world!
