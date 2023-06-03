fun main(args: Array<String>) {
    println("Welcome to task manager, where we can help you keep track of your to do list. ")
    var run = true
    var tasks = ArrayList<Task>()
    val schoolTask = Type("School", 1)
    val homeTask = Type("Home", 2)
    val miscTask = Type("Miscellaneous", 3)

    while(run)
    {
        println("\nPlease choose an option from the following menu:")
        println("1. Create a new task")
        println("2. Display all tasks")
        println("3. Display incomplete tasks")
        println("4. Complete a task")
        println("5. Exit")
        val input = readLine()

        if (input == "1") {

            println("What is a short description of your task? ")
            val desc = readLine()
            var noTask = true
            var type = Type("", 0)
            while (noTask) {

                println("Which of the following categories does this task fit into? ")
                println("1. School")
                println("2. Home")
                println("3. Miscellaneous")
                val inputType = readLine()
                if (inputType == "1") {
                    type = schoolTask
                    noTask = false
                } else if (inputType == "2") {
                    type = homeTask
                    noTask = false
                } else if (inputType == "3") {
                    type = miscTask
                    noTask = false
                } else {
                    println("Invalid input. Please select an option from the list. ")
                }
            }
            var task = Task(desc, type)
            tasks.add(task)
        }
        else if (input == "2"){
            tasks.sortBy{ it.type.getPriority() }
            var count = 1
            var schoolPrint = false
            var homePrint = false
            var miscPrint = false
            for(task in tasks){
                if(task.type.getPriority() == 1 && !schoolPrint){
                    println("\nSchool tasks:")
                    schoolPrint = true
                }
                else if(task.type.getPriority() == 2 && !homePrint){
                    println("\nHome tasks:")
                    homePrint = true
                }
                else if(task.type.getPriority() == 3 && !miscPrint){
                    println("\nMiscellaneous tasks:")
                    miscPrint = true
                }
                print("$count . ")
                task.display()
                count += 1
            }
        }
        else if(input == "3"){
            tasks.sortBy{ it.type.getPriority() }
            var count = 1
            var schoolPrint = false
            var homePrint = false
            var miscPrint = false
            for(task in tasks){
                if(!task.getIsComplete()) {
                    if (task.type.getPriority() == 1 && !schoolPrint) {
                        println("\nSchool tasks:")
                        schoolPrint = true
                    } else if (task.type.getPriority() == 2 && !homePrint) {
                        println("\nHome tasks:")
                        homePrint = true
                    } else if (task.type.getPriority() == 3 && !miscPrint) {
                        println("\nMiscellaneous tasks:")
                        miscPrint = true
                    }
                    print("$count . ")
                    task.display()
                    count += 1
                }
            }
        }
        else if (input == "4"){
            println("Which task would you like to complete? (Program will not display tasks that are already complete)")
            var count = 1
            for(task in tasks)
            {
                if(!task.getIsComplete()){
                    print("$count . ")
                    task.display()
                }
                count += 1
            }
            val indexInput = readln()
            var index = indexInput.toInt()
            index -= 1
            tasks[index].completeTask()
        }
        else if (input == "5"){
            run = false
        }
        else{
            println("Invalid input. Please select an option from the list. ")
        }
    }

}