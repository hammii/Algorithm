import Foundation

func solution(_ n:Int, _ lost:[Int], _ reserve:[Int]) -> Int {
    var lost_set = Set(lost.filter { !reserve.contains($0) })
    var reserve_set = Set(reserve.filter{ !lost.contains($0) })
    let sorted_lost = Array(lost_set).sorted()
    
    for l in sorted_lost {
        if reserve_set.contains(l-1) {
            reserve_set.remove(l-1)
            lost_set.remove(l)
        } else if reserve_set.contains(l+1) {
            reserve_set.remove(l+1)
            lost_set.remove(l)
        }
    }

    return n - lost_set.count
}
