# ProgressPal: A to-do list app that rewards you every time you complete a task
## Motivation
  This program was first intended to be a fun and new way to approach doing your homework. A way that gives you motivation without burning you out. Although there is no database being utilized in the creation and completion of tasks, in the future there might be a way to share progress with friends and better motivate you to do your homework.
## Build Status
  The current build status of ProgressPal is under development, but still passing all tests at the moment
## Code Style
  The language used to write this app is Java
## Screenshots of how the app looks
  [Adobe XD of the App](https://xd.adobe.com/view/bbeae482-0e6c-4fc8-9407-9e29133aa716-eeb9/)
## A Video Demonstration of the App
  [Project Demo](https://drive.google.com/file/d/1DNMQ9E8FhB0Jqn4SM699c-VBLvl7Gn1f/view?usp=drive_link)
## Tech Used
  We used **Android Studio** to code the app, **Instagram** to communicate with each other, and **GitHub** for version control. **Adobe XD** was used for the initial design of the app, and **Google Docs** was where we uploaded and kept many of the assets used in the app.
# Here is some code to show the main functionality of the app
public class TaskTracker {

    private final ArrayList<Task> tasks;
    private final Activity activity;
    private final String filename;
    private final Stats stats;

    public TaskTracker(Activity activity, Stats stat) {
        this.stats = stat;
        tasks = new ArrayList<>();
        this.activity = activity;
        filename = "tasks4.csv";
    }

    public void initializeTasks(){

        try{

            System.out.println("Attempting to read from file...");
            InputStream in = activity.openFileInput(filename);
            System.out.println("Success");
            loadTasks(in);
        }
        catch(FileNotFoundException e){

            System.out.println("unable to read from file. File does not exist. " + filename);

            try{
                System.out.println("Attempting to create file ...");
                OutputStream out = activity.openFileOutput(filename, Context.MODE_PRIVATE);
            }
            catch(FileNotFoundException e2){
                System.out.println("Unable to create file. " + filename);
            }
        }
    }

    public void loadTasks(InputStream in){

        if(in != null){
            Scanner scan = new Scanner(in);
            String taskInfo = "";
            String[] tokens;

            while(scan.hasNextLine()){
                taskInfo = scan.nextLine();
                tokens  = taskInfo.split(",");
                int completionTime = Integer.parseInt(tokens[2]);
                addTasks(new Task(tokens[0], tokens[1], completionTime));
            }
        }
    }

    public void saveTasks() {

        try{
            System.out.println("Attempting to save to a file");
            OutputStream out = activity.openFileOutput(filename, Context.MODE_PRIVATE);

            if(tasks != null) {
                for (Task task : tasks) {
                    out.write(task.getName().getBytes(StandardCharsets.UTF_8));
                    out.write(",".getBytes(StandardCharsets.UTF_8));
                    out.write(task.getDueDate().getBytes(StandardCharsets.UTF_8));
                    out.write(",".getBytes(StandardCharsets.UTF_8));
                    out.write(String.valueOf(task.getCompletionTime()).getBytes(StandardCharsets.UTF_8));
                    out.write("\n".getBytes(StandardCharsets.UTF_8));
                }
            }

            out.close();
        }
        catch(IOException e){
            System.out.println("Failed to write to file. " + filename);
        }
    }

    public void addTasks(Task task){
        tasks.add(task);
    }

    public void deleteTask(Task task){
        stats.setTotalXP(stats.getTotalXP() + task.getXp());
        stats.setTasksCompleted(stats.getTasksCompleted()+1);
        tasks.remove(task);
        stats.saveStats();
        saveTasks();
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }


//tallies up the total xp, called from pointsActivity
    public int getTotalXp() {
        int totalXp = 0;
        for (Task task : tasks) {
            totalXp += task.getXp();
        }
        return totalXp;
    }
}
## Known Issues
  We could not synchronize a calendar with the tasks and their dates
## Installation
  The app is not available on the app store, but with a link to the GitHub repository, one should be able to run the app via Android Studio

## How to use
  The app is fairly straightforward to use. The Home page is where the tasks are displayed, created, and completed. On the Profile Page, you can view statistics, and choose customization options, which are not all available until you accrue a certain amount of experience points. On the streaks page, you get to see the total amount of xp gained. And lastly, the credits page cites the developers of the app and links their GitHub pages.

## Credits
  The people involved and their GitHub links are: [Matthew](https://github.com/mattyb8591) [Marc](https://github.com/marcdjbn) [Eli](https://github.com/Etap4496) and [Leslie](https://github.com/LeslieH0)
