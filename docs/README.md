# User Guide

## Features 

### 1. Add Todo
Add a todo task to your task list.

### 2. Add Deadline
Add a deadline to your task list.

### 3. Add Event
Add an event task to your task list.

### 4. Mark task as Done
Mark a task in your task list as done.

### 5. List all tasks
List all tasks in your task list.

### 6. Delete task
Delete a task from your task list.

### 7. Find task
Find tasks containing a keyword.

### 8. Save task list
Save your task list to a .txt file.

### 9. Help 
View list of available commands.



## Usage

### `todo <task description>` - Add a Todo task

Add a Todo task to your task list.

Example of usage: 

`todo read book`

Expected outcome:

```	
=====================================================
	Added: [T][✘] read book
Now you have 1 task(s) in your list!
=====================================================
```

### `deadline <task description> /by <date>` - Add a Deadline

Add a Deadline task to your task list.

Example of usage: 

`deadline return book /by Monday`

Expected outcome:

```	
=====================================================
	Added: [D][✘] return book (by: Monday)
Now you have 2 task(s) in your list!
=====================================================
```

### `event <task description> /at <date>` - Add an Event

Add an Event task to your task list.

Example of usage: 

`event book fair /at 5pm Tuesday`

Expected outcome:

```	
=====================================================
	Added: [E][✘] book fair (at: 5pm Tuesday)
Now you have 3 task(s) in your list!
=====================================================
```

### `done <task index>` - Mark task as done 

Mark a task in your task list as done.

Example of usage: 

`done 1`

Expected outcome:

```	
=====================================================
	Nice! I've marked this task as done:
		[T][✓] read book
=====================================================
```

### `list` - List all tasks

List all tasks in your task list.

Example of usage: 

`list`

Expected outcome:

```	
TASK LIST
=====================================================
1. [T][✓] read book
2. [D][✘] return book (by: Monday)
3. [E][✘] book fair (at: 5pm Tuesday)
=====================================================
```

### `delete <task index>` - Delete a task

Delete a task from your task list.

Example of usage: 

`delete 1`

Expected outcome:

```	
=====================================================
	Removed: [T][✓] read book
Now you have 2 task(s) in your list
=====================================================
```

### `find <keyword>` - Find tasks

Find tasks with matching keyword.

Example of usage: 

`find book`

Expected outcome:

```	
These are the matching tasks from your list!
TASK LIST
=====================================================
1. [D][✘] return book (by: Monday)
2. [E][✘] book fair (at: 5pm Tuesday)
=====================================================
```

### `save` - Save task list

Save task list to .txt file.

Example of usage: 

`save`

Expected outcome:

```	
	Successfully saved to file!
```

### `help` - View help

View list of available commands

Example of usage: 

`help`

Expected outcome:

```	
=====================================================
	Command List
		Add ToDo --------- todo <task desc>
		Add Deadline ----- deadline <task desc> \by <date>
		Add Event -------- event <task desc> \by <date>
		Mark Done -------- done <task index>
		Delete task ------ delete <task index>
		List tasks ------- list
		Save task list --- save
		Find task -------- find <keyword>
		Command list ----- help
		Exit Anyllama ---- bye

=====================================================

```

