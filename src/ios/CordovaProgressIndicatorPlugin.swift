import UIKit
import SVProgressHUD

@objc(CordovaProgressIndicatorPlugin) class ModusEchoSwift : CDVPlugin {
    @objc(show:)
    func show(command: CDVInvokedUrlCommand) {
        let pluginResult = CDVPluginResult(
            status: CDVCommandStatus_OK
        )

        let msg = command.arguments[0] as? String ?? ""

        if msg.characters.count == 0{
            SVProgressHUD.show()
        }
        else
        {
            SVProgressHUD.show(withStatus: msg)
        }

        self.commandDelegate!.send(
            pluginResult,
            callbackId: command.callbackId
        )
    }
}