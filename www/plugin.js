cordova.define("cordova-progress-indicator-plugin.plugin", function(require, exports, module) {

    var exec = require('cordova/exec');

    var PLUGIN_NAME = 'CordovaProgressIndicatorPlugin';

    var CordovaProgressIndicatorPlugin = {
        show: function(message) {
            exec(cb, null, PLUGIN_NAME, 'show', [message]);
        },
        hide: function(cb) {
            exec(cb, null, PLUGIN_NAME, 'hide', []);
        }
    };

    module.exports = CordovaProgressIndicatorPlugin;

});
