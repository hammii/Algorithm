import Foundation

func solution(_ s:String) -> Bool
{
    var stack = [Character]()
    
    for a in s {
        if a == ")" {
            if stack.isEmpty {
                return false
            }
            
            let top = stack.popLast()
            if top != "(" {
                return false
            }
            
        } else if a == "(" {
            stack.append("(")
        }
    }

    return stack.isEmpty
}
