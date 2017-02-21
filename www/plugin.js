var exec = require('cordova/exec');
var PLUGIN_NAME = 'CordovaProgressIndicatorPlugin';

exports.show = function(arg0, success, error) {
    exec(success, error, PLUGIN_NAME, 'show', [arg0]);
};

exports.hide = function( success, error) {
    exec(success, error, PLUGIN_NAME, 'hide', []);
};

exports.isShown = function( success, error) {
    exec(success, error, PLUGIN_NAME, 'isShown', []);
};
