// The following will be accepted as input in the following format: "title:author:price"
// Example Input:   "ProgrammingLanguages:Chen:45"
// Valid title:     String containing alphabetical letters beginning with a capital letter
// Valid author:    String containing alphabetical letters beginning with a capital letter
// Valid price:     A float variable


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

#pragma warning(disable: 4996)

// used to create a linked list of containers, each contaning a "book"
struct container {
    struct book *book;
    struct container *next;
} *list = NULL;

// used to hold book information and linked list of "frequently bought together (fbt)"
struct book {
    char title[30];
    char author[30];
    float price;
    struct fbt *fbts;
};

// used to create a linked list of frequently bought together (fbt)
struct fbt {
    struct book *book;
    struct fbt *next;
};


// forward declaration of functions that have already been implemented
void flush();
void branching(char);
void registration(char);

int main()
{
    char ch = 'i';
    printf("Book Information\n\n");

    do
    {
        printf("Please enter your selection:\n");
        printf("\ta: add a new book to the list\n");
        printf("\ts: search for a book on the list\n");
        printf("\tr: remove a book from the list\n");
        printf("\tl: print the list of all books\n");
        printf("\tb: buy a book\n");
        printf("\tq: quit\n");
        ch = tolower(getchar());
        flush();
        branching(ch);
    } while (ch != 'q');

    return 0;
}

// consume leftover '\n' characters
void flush()
{
    int c;
    do c = getchar(); while (c != '\n' && c != EOF);
}

// branch to different tasks
void branching(char c)
{
    switch (c)
    {
        case 'a':
        case 's':
        case 'r':
        case 'l':registration(c); break;
        case 'b':{
            struct container * buy = buy_book();

            buy = setfbt(buy);

            display_fbt(buy);
            break;
        }
        case 'q': break;
        default: printf("Invalid input!\n");
    }
}

void registration(char c)
{
    if (c == 'a')
    {
        char input[100];

        printf("\nPlease enter the book's info in the following format:\n");
        printf("title:author:price\n");
        fgets(input, sizeof(input), stdin);

        // discard '\n' chars attached to input
        input[strlen(input) - 1] = '\0';

        char* title = strtok(input, ":"); // strtok used to parse string
        char * author = strtok(NULL, ":");
        float price = atof(strtok(NULL, ":"));

        struct book* result = search_book(title);

        if (result == NULL)
        {
            add_book(title, author, price);
            printf("\nBook added to list successfully\n\n");
        }
        else
            printf("\nThat book is already on the list\n\n");
    }
    else if (c == 's' || c == 'r' )
    {
        char title[30];

        printf("\nPlease enter the book's title:\n");
        fgets(title, sizeof(title), stdin);

        // discard '\n' chars attached to input
        title[strlen(title) - 1] = '\0';

        struct book* result = search_book(title);

        if (result == NULL)
            printf("\nThat book is not on the list\n\n");
        else if (c == 's'){
            printf("\nTitle: %s\n", result->title);
            printf("Author: %s\n", result->author);
            printf("Price: %.2f\n\n", result->price);
        }
        else
        {
            remove_book(title);
            printf("\nBook removed from the list\n\n");
        }
    }
    else
    {
        print_all_books();
    }
}


// This function should add book to the head of the list of containers.
void add_book(char* title, char* author, float price) //copies each element of the book struct the user inputs
{
    struct book *addBook;
    struct container *insertBook;

    addBook = (struct book *) malloc(sizeof(struct book));
    insertBook = (struct container *) malloc(sizeof(struct container));

    strcpy(addBook->title, title); //book struct
    strcpy(addBook->author, author);
    addBook->price = price;
    addBook->fbts = NULL;

    insertBook->book = addBook; //container struct
    insertBook->next = list;
    list = insertBook;  //addBook will be at the head of the list
}

// hw07 Q2 : search (10 points)
// In this function, you are passed the title of a book to find.
// If the book exists on the list, return a pointer to the requested book. If not, return NULL.
// (You must return a pointer to a node in your list.)

struct book* search_book(char* title)
{
    struct container *findBook = list;

    while(findBook != NULL){
        if (strcmp(findBook->book->title, title) == 0){
            return findBook->book;
        }

        findBook = findBook->next; //iterates through the list
    }
    return NULL; //book doesnt exist if reached
}

{
    struct container *memoryManage = list;
    struct container *removeOne = list;
    struct fbt* temp;

    if (strcmp(list->book->title, title) == 0){
        while(list->book->fbts != NULL){
            temp = list->book->fbts;
            list->book->fbts = list->book->fbts->next;

            free(temp); //memory management 3 levels in
        }
        list = list->next;
        free(memoryManage->book); //mem managment 2 levels in
        free(memoryManage); //garbage (no longer used memory) collected

    }

    else{
        removeOne = list->next; //iterates through the list
        while(removeOne->next != NULL){ //nested while loop to keep track of frequently bought together structure of book
            if(strcmp(memoryManage->book->title, title) == 0){
                while(memoryManage->book->fbts != NULL){ //need to properly collect unused fbts memory since the book is being removed from the list
                    temp = memoryManage->book->fbts;
                    memoryManage->book->fbts = memoryManage->book->fbts->next;
                    free(temp); //memory management
                }
                removeOne->next = memoryManage->next;
                free(memoryManage->book);
                free(memoryManage);
                break;

            }
            removeOne = memoryManage;
            memoryManage = memoryManage->next; //iterate to next in the list
        }
    }

}

void print_all_books() //iterate through list and print title, author, price of each respective book
{
    struct container *bookIterator = list;
    if (bookIterator == NULL){
        printf("\nThere are no books on this list!\n\n\n");
        return;
    }
    while(bookIterator != NULL){
        printf("Title: %s\n", bookIterator->book->title);
        printf("Author: %s\n", bookIterator->book->author);
        printf("Price: %f\n", bookIterator->book->price);

        bookIterator = bookIterator->next; //go through list
        printf("\n\n");
        continue; //finish while loop properly
    }
}

// The user should be able to buy as many books as he/she wants until 'n' is pressed.
struct container * buy_book(){  //returns linked list of all the books the user wants to buy
    struct container *bookPurchases = NULL;

    printf("Do you want to buy a book? y for Yes and n for No: "); //user input to buy by a book title
    char charInput = getchar();
    if(charInput == 'y'){
        while(true){
            char *userInput;
            printf("\nPlease enter the book's title:\n");
            scanf("%s", userInput);

            if(*userInput == 'n'){ //ends buy_book if n is inputted at this stage
                break;
            }
            else{
                if(search_book(userInput) == NULL){
                    printf("That book is not found!");
                }
                else{ //book is found list, add to bookPurchases list based on title

                    struct container *insertContainer;
                    insertContainer = (struct container *) malloc(sizeof(struct container));
                    insertContainer->book = search_book(userInput);
                    insertContainer->next = bookPurchases;
                    bookPurchases = insertContainer; //bookPurchases will be the head of the list
                }
            }

        }
    }

    else if(charInput == 'n'){ //do nothing and go back to initial branch prompt

    }

    else{  //user didnt input y or n

    }

    return bookPurchases;
}



// When a user buys a book, the frequently bought togther(fbt) linked list should be updated for each book.
struct container *  setfbt (struct container * in){
    // Build fbts for every book that the user buys
    struct fbt * fbtHead = NULL; //keeps track of the head of in (linked list)
    struct container *purchasesIterator = in; 

    // Setup linked list of fbts (keep track of with fbtHead)
    while(purchasesIterator != NULL){
        struct fbt *newFbt = (struct fbt *) malloc(sizeof(struct fbt)); //constructs a fbt node for each bookPurchased
        newFbt->book = purchasesIterator->book; 
        newFbt->next = fbtHead;
        fbtHead = newFbt;
        
        purchasesIterator = purchasesIterator->next;
    }

    // Assign each purchased book list of fbts
    purchasesIterator = in;
    while(purchasesIterator != NULL) {
        purchasesIterator->book->fbts = fbtHead;
        purchasesIterator = purchasesIterator->next;
    }

    return in; //added fbt to each purchased book
}

void display_fbt(struct container* books) //print all books bought and their respective title, author, price and fbt
{
    struct container *bookIterator = books;

    while(bookIterator != NULL){

        printf("Title: %s\n", bookIterator->book->title);
        printf("Author: %s\n", bookIterator->book->author);
        printf("Price: %f\n", bookIterator->book->price);

        // Loop through fbts, print each book
        struct fbt* fbtIterator = bookIterator->book->fbts;
        while(fbtIterator != NULL) {
            if(fbtIterator->book != bookIterator->book){ // only print book from fbt list if its not the same as current book
                printf("Frequently Bought Together Book: \n");
                printf("Title: %s\n", fbtIterator->book->title);
                printf("Author: %s\n", fbtIterator->book->author);
                printf("Price: %f\n", fbtIterator->book->price);
            }
            fbtIterator = fbtIterator->next; 
        }

        bookIterator = bookIterator->next; //go through list
        printf("\n\n");
    }
}
