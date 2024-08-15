Domain model exercise

| Classes  | Variables               | Methods                        | Scenarios                                                      | Outcome                                             |
|----------|-------------------------|--------------------------------|----------------------------------------------------------------|-----------------------------------------------------|
| ToDoList | 'ArrayList<Task> tasks' | 'addTask(String name)'         | Add a task with a unique name                                  | Return 'true' and add task to tasks                 |
|          |                         |                                | Add a task with an already existing name 'name'                | Return 'false'                                      |
|          |                         | 'viewTasks(Boolean ascending)' | View all the tasks in tasks with 'ascending' set to 'true'     | Return tasks and print it in ascending order        |
|          |                         |                                | View all the tasks in tasks with 'ascending' set to 'false'    | Return tasks and print it in descending order       |
|          |                         | 'completeTask(String name)'    | Set a incomplete task to completed                             | Return 'true'                                       |
|          |                         |                                | Tried to set a completed task to completed                     | Return 'false'                                      |
|          |                         | 'incompleteTask(String name)'  | Set a completed task to incomplete                             | Return 'true'                                       |
|          |                         |                                | Tried to set a incomplete task to incomplete                   | Return 'false'                                      |
|          |                         | 'getCompletedTasks()'          | View all completed tasks in tasks                              | Return ArrayList of completed tasks and print them  |
|          |                         | 'getIncompleteTasks()'         | View all incomplete tasks in tasks                             | Return ArrayList of incomplete tasks and print them |
|          |                         | 'search(String name)'          | Search for an existing task with name 'name'                   | Return 'true' and print name and completed status   |
|          |                         |                                | Search for a non-existing task                                 | Return 'false' and print "Task was not found"       |
|          |                         | 'removeTask(String name)'      | Remove existing task with name 'name'                          | Return 'true'                                       |
|          |                         |                                | Tried to remove non-existent task                              | Return 'false' and print "Task was not found"       |
| Task     | 'Boolean completed'     | 'setCompleted()'               | Set task to completed if task in incomplete                    | Return 'true'                                       |
|          |                         |                                | Tried to set task to completed but task is already completed   | Return 'false'                                      |
|          |                         | 'setIncomplete()'              | Set task to incomplete if task is completed                    | Return 'true'                                       |
|          |                         |                                | Tried to set task to incomplete but task is already incomplete | Return 'false'                                      |
|          | 'String name'           |                                |                                                                |                                                     |


Domain model extensio