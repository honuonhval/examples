"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.MyComponent = undefined;

var _react = require("react");

var _react2 = _interopRequireDefault(_react);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var MyComponent = function MyComponent(_ref) {
  var key = _ref.key;

  console.log('child props', key);
  return _react2.default.createElement(
    "li",
    { key: key },
    "Hello JSX! I'm child number ",
    key,
    "!"
  );
};

var MyDefaultComponent = function MyDefaultComponent(_ref2) {
  var children = _ref2.children;
  return _react2.default.createElement(
    "div",
    null,
    _react2.default.createElement(
      "h1",
      null,
      "Hello JSX!"
    ),
    _react2.default.createElement(
      "ul",
      null,
      children
    )
  );
};

exports.MyComponent = MyComponent;
exports.default = MyDefaultComponent;