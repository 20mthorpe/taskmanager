class Task(private val description: String?, val type: Type) {
    private var isComplete = false
    fun completeTask(){
        isComplete = true
    }
    fun getIsComplete(): Boolean{
        return isComplete
    }
    fun display(){
        if (isComplete){
            println("✓ Task: $description")
        }
        else{
            println("O Task: $description")
        }
    }
}
class Type(private val name: String, private val priority: Int) {
    fun getPriority(): Int{
        return priority
    }
}
