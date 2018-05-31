## intro-to-prejenter

My slides to introduce [Prejenter](https://github.com/athos/prejenter),
a presentation framework written in Clojure.

## Prerequisites

- Java
- [Clojure CLI tool](https://clojure.org/guides/deps_and_cli)
- Emacs
- [CIDER](https://github.com/clojure-emacs/cider)

## Usage

First, start Clojure REPL from CIDER, using `cider-jack-in` or something.

Then, enter the following statements in the REPL:

```clj
(use 'prejenter.repl)
(start! 'intro-to-prejenter.slides)
```

And you'll see a slide image shown in the REPL buffer.

You can go back and forth with `(prev!)` and `(next!)`. If you want to jump to
a specific page, use `(goto! <page>)` instead.

## License

Copyright © 2018 Shogo Ohta

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
