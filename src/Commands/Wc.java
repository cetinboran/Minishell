package Commands;

public class Wc extends Command{
    public Wc(String name, String args, String options) {
        super(name, args, options);
    }

    @Override
    public void run() {
        if(this.getOptions() == null){
            emptyOption();
        }
    }

    private void emptyOption(){
        int lineCount = 1;
        int wordCount = 0;
        int charCount = 0;

        boolean isWord = false;
        if(!getStdI()){

            if(getInput() == null){
                System.out.println("input yok");
                return;
            }

            for(int i = 0; i < getInput().length(); i++){
                char c = getInput().charAt(i);
                if((c != ' ') && !isWord) {
                    isWord = true;
                    wordCount++;
                }
                else if(c == ' ' || c == '\n'){
                    isWord = false;
                }
                if(c == '\n'){
                    lineCount++;
                }

                charCount++;
            }

            // STDO 0 olduğu için çıktı ekrana gider
            if(!getStdO()){
                System.out.print(lineCount + " " + wordCount +  " " + charCount);
            }
            else{
                // STD1 ise pipe'ın outputu alıp diğer komuta atması için değişkene atıyoruz.
                setOutput(lineCount + " " + wordCount +  " " + charCount);
            }
        }
    }
}
