import * as React from "react";

const MyComponent = ({ key }) => {
  console.log('child props', key);
  return React.createElement(
    "li",
    { key: key },
    "Hello JSX!"
  );
};

const MyDefaultComponent = ({ children }) => React.createElement(
  "div",
  null,
  React.createElement(
    "h1",
    null,
    "Hello JSX!"
  ),
  React.createElement(
    "ul",
    null,
    children
  )
);

export { MyComponent };

export default MyDefaultComponent;