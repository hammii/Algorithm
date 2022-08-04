func solution(_ s:String) -> String {
    var result = ""
    
    for i in 0..<s.count {
        let cur = s[String.Index(encodedOffset: i)]
        
        if i == 0 {
            result += cur.uppercased()
        } else {
            let prev = s[String.Index(encodedOffset: i-1)]
            
            if prev == " " && cur != " " {
                result += cur.uppercased()
            } else {
                result += String(cur.lowercased())
            }
        }
    }
    
    return result
}
