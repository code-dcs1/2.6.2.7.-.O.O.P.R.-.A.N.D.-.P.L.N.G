def lastWord():
    word1 = input("Input the first word: ")
    word2 = input("Input the second word: ")
    word3 = input("Input the third word: ")

    last_word = max(word1,word2,word3, key=str.lower)
    print(f"The word that comes last alphabetically is {last_word}")

lastWord()

    