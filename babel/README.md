# babel-example

This example shows how to use and Clojuresript with local Javascript transpiled with `babel-cli`.

### Instructions

Install Javascript dependencies:
```
yarn 
```

Watch and transpile JS files with `babel-cli`:
```
yarn watch
```

Run the app:
```
shadow-cljs watch dev
```

The app should be available at `localhost:8280`.


### Overview
This example is based on the [user guide section on Javascript dialects](https://shadow-cljs.github.io/docs/UsersGuide.html#_language_support). 

### Project structure
```
.
├── dev
│   └── user.clj
├── package.json
├── public
│   ├── index.html
│   └── js
│       └── compiled
│           ├── base.js
│           ├── cljs-runtime
│           └── manifest.edn
├── shadow-cljs.edn
└── src
    ├── gen
    │   └── demo
    │       └── bar.js
    ├── js
    │   └── demo
    │       └── bar.js
    └── main
        └── demo
            └── app.cljs
```
The `src/js` folder contains our Javascript source code. `yarn watch` transpiles the contents of this folder with `babel` and 
outputs the transpiled result to `src/gen`. 

By listing the generated folder as a `:source-path` in `shadow-cljs.edn`, we can `:require` it like any other JS file.

```cljs
(ns demo.app
  (:require ["react" :as react]
            ["react-dom" :refer (render)]
            ["./bar" :refer (MyComponent) :default MyDefaultComponent]))

```

Try changing `src/js/demo/bar.js` to something like this:

```js
const MyComponent = ({ key }) => 
  <li key={key}>
    Hello JSX! I'm child number {key}!
  </li>

```

Because our Clojurescript code in `main/demo/app.cljs` requires `./bar` (and we've set `babel` to output when any file in `src/js` changes), we can change the React code and get hot reloading.


Clojurescript hot reloading still works, too. Try changing `num-children` in `main/demo/app.cljs` to something like 42:

```cljs
(defn root []
  (let [num-children 42
        children-props (clj->js (map hash-map
                                     (repeat num-children :key)
                                     (range num-children)))]
    (MyDefaultComponent #js {:children (mapv MyComponent children-props)})))


```

In the browser, you should see:

![image](https://user-images.githubusercontent.com/9045165/38771997-c7267f78-3fe1-11e8-90e1-586794824853.png)

Neat!

