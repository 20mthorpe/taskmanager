fun main(args: Array<String>) {

    // Welcome
    println("Welcome to task manager, where we can help you keep track of your to do list. ")

    // For menu loop
    var run = true

    // Create list to hold tasks
    var tasks = ArrayList<Task>()

    // Create task types
    val schoolTask = Type("School", 1)
    val homeTask = Type("Home", 2)
    val miscTask = Type("Miscellaneous", 3)

    // Run the main program
    while(run)
    {
        //Display Menu
        println("\nPlease choose an option from the following menu:")
        println("1. Create a new task")
        println("2. Display all tasks")
        println("3. Display incomplete tasks")
        println("4. Complete a task")
        println("5. Exit")
        val input = readLine()

        // Create a new task
        if (input == "1") {

            // Get description
            println("What is a short description of your task? ")
            val desc = readLine()

            //Get task type
            var noType = true
            var type = Type("", 0)
            while (noType) {

                println("Which of the following categories does this task fit into? ")
                println("1. School")
                println("2. Home")
                println("3. Miscellaneous")

                val inputType = readLine()
                if (inputType == "1") {
                    type = schoolTask
                    noType = false
                } else if (inputType == "2") {
                    type = homeTask
                    noType = false
                } else if (inputType == "3") {
                    type = miscTask
                    noType = false
                } else {
                    println("Invalid input. Please select an option from the list. ")
                }
            }
            // Create task, add to list, sort list by priority
            var task = Task(desc, type)
            tasks.add(task)
            tasks.sortBy{ it.type.getPriority() }
        }

        // Display all tasks
        else if (input == "2"){

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

        // Display only incomplete tasks
        else if(input == "3"){

            var count = 1

            // We only want to print the type once so use boolean variables to do this
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

        // Complete a task
        else if (input == "4"){
            println("Which task would you like to complete? (Program will not display tasks that are already complete)")
            var count = 1

            // Display tasks
            for(task in tasks)
            {
                if(!task.getIsComplete()){
                    print("$count . ")
                    task.display()
                }
                count += 1
            }
            //Get task to be completed, then complete the task
            val indexInput = readln()
            var index = indexInput.toInt()
            index -= 1//change to an index
            tasks[index].completeTask()
        }

        // Exit the loop and program
        else if (input == "5"){
            // end while loop
            run = false
        }

        // Invalid input
        else{
            println("Invalid input. Please select an option from the list. ")
        }
    }

}