func solution(_ s:String) -> String {
    var result = ""
    
    if s.count % 2 == 0 {
        let len = (s.count - 1) / 2
        result = String(Array(s)[len...len+1])
    } else {
        let len = s.count / 2
        result = String(Array(s)[len])
    }
    
    return result
}
