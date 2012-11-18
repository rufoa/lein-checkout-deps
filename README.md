# lein-checkout-deps

A leiningen 2 plugin to facilitate tracking SNAPSHOT dependencies in
checkouts.

With this plugin installed, before leinignen runs the `deps` task it
will run `lein install` in each checkout repository. This will ensure
the very latest SNAPSHOT version of each checkout is available
locally, which will ensure transitive dependencies are picked up.

## Usage

Add `[lein-checkout-deps "1.0.0"]` to `:plugins` in profiles.clj