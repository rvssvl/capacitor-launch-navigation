import Foundation

@objc public class LaunchNavigationPlugin: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
