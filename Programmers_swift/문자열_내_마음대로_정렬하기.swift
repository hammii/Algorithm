func solution(_ strings:[String], _ n:Int) -> [String] {
    let result = strings.sorted { a, b in
        let a_arr = Array(a)
        let b_arr = Array(b)
        
        if a_arr[n] != b_arr[n] {
            return a_arr[n] < b_arr[n]
        }
        return a < b
    }
    
    return result
}
