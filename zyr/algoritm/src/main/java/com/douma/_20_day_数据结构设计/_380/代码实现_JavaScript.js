/**
 * Initialize your data structure here.
 */
var RandomizedSet = function() {
    this.idxMap = new Map()
    this.nums = []
};

/**
 * Inserts a value to the set. Returns true if the set did not already contain the specified element. 
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.insert = function(val) {
    if (this.idxMap.has(val)) return false
    this.idxMap.set(val, this.nums.length)
    this.nums.push(val)
    return true
};

/**
 * Removes a value from the set. Returns true if the set contained the specified element. 
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.remove = function(val) {
    if (!this.idxMap.has(val)) return false
    const index = this.idxMap.get(val)
    const lastNum = this.nums[this.nums.length - 1]

    this.nums[index] = lastNum
    this.idxMap.set(lastNum, index)

    this.nums.pop()
    this.idxMap.delete(val)
    return true
};

/**
 * Get a random element from the set.
 * @return {number}
 */
RandomizedSet.prototype.getRandom = function() {
    return this.nums[Math.floor(Math.random() * this.nums.length)]
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = new RandomizedSet()
 * var param_1 = obj.insert(val)
 * var param_2 = obj.remove(val)
 * var param_3 = obj.getRandom()
 */