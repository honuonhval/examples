# proto-repl with shadow-cljs

```
yarn global add shadow-cljs
shadow-cljs server

```

Then run Atom and use proto-repl nrepl remote to connect to localhost:11100.

The connected REPL starts out as a CLJ REPL.

Compile the `:app` build once like this

```
(shadow.cljs.devtools.api/compile :app)
```

For development start a worker process which will watch source files and recompile code on changes. It will also provide the REPL.
```
(shadow.cljs.devtools.api/watch :app)
```

It serves the HTML at http://localhost:11101

It doesn't do much but if you open the Console it should show:

```
hello world
DEVTOOLS: connected!
DEVTOOLS: repl init successful
```

You can then switch the Proto-REPL to CLJS by calling

```
(shadow.cljs.devtools.api/nrepl-select :app)
```

This switches the current REPL session to a CLJS REPL.

```
(js/alert "foo")
```

Should show the alert in the browser window.

```
:repl/quit
:cljs/quit
```

Either of these return the REPL session back to CLJS. The worker will keep running and you can resume the REPL where you left it by just selecting it again.
