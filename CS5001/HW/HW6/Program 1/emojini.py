"""
Wenqing Zeng
CS 5001 Homework 6 program 1
This program is about translate emoji
"""
import copy


def process_directives(directives_file_path):
    """
        Function: process_directives()
            Read and process a directive file line by line
        Parameters:
            directives_file_path — str — file path to be read
        Returns - list - a list of lists, words in directive file
        Exceptions:
            FileNotFoundError: If file is null then catch
            and the function returns an empty list
        """
    command = []
    try:
        with open(directives_file_path, mode='r', encoding="UTF-8") as infile:
            for each in infile:
                splitted = each.split()
                command.append(splitted)
    except FileNotFoundError:
        print("read file not successful. File name: " + directives_file_path)
        pass
    return command


def check_english(current_directive):
    """
        Function: check_english()
            Check if the origin and target languages are English
        Parameters:
            current_directive — list — a list origin, target languages,
                                        file paths
        Returns - tuple - (english_key, english_target) both are boolean
                         these two will be used when building dictionary
                         and in actual search & replacing
    """
    origin_lang = current_directive[0]
    target_lang = current_directive[1]
    if origin_lang.upper() == "ENGLISH":
        english_key = True
    else:
        english_key = False
    if target_lang.upper() == "ENGLISH":
        english_target = True
    else:
        english_target = False
    return english_key, english_target


def build_temp_dict(current_directive, metadata, association):
    """
        Function: build_temp_dict()
            build a temporary dictionary for language translation mappings
        Parameters:
            current_directive — list — a list has origin and target languages
            metadata — list — contains names of each row's items
            association — list — contains entries of words in
                            english and/or emoji form/dialect
        Returns - temp_dict - temporary dictionary of translation
    """
    temp_dict = {}

    if len(current_directive) < 1 or len(metadata) < 1 or len(association) < 1:
        # any of these three above is empty then
        pass
    else:
        english_key, english_target = check_english(current_directive)
        ol = current_directive[0].strip().upper()
        tl = current_directive[1].strip().upper()
        index_origin_lang = metadata.index(ol)
        index_target_lang = metadata.index(tl)
        for entry in association:
            origin_str = entry[index_origin_lang]
            target_str = entry[index_target_lang]
            if english_key:
                origin_str = origin_str.lower()
                temp_dict[origin_str] = target_str
            else:
                if english_target:
                    temp_dict[origin_str] = target_str.lower()
                else:
                    temp_dict[origin_str] = target_str
    return temp_dict


def do_translation(current_directive, dictionary):
    """
        Function: do_translation()
            Consult dictionary and directives to translate in-file's strings
            and write translated text to output
        Parameters:
            current_directive — list — a  list has entries of task
            dictionary — dict — pre-built dictionary
        Returns: None
        Exceptions:
            FileNotFoundError: If the origin or target file does not exist,
                               a message is printed.
            IndexError: Used to make sure first alphabetical character
                        is capitalized. But if not then ignore
                        by catching this error and pass
                        since its length will be 0
    """
    origin_file = current_directive[2]
    target_file = current_directive[3]
    try:
        if len(dictionary) < 1:
            print("Warning: Dictionary is empty")
            with (open(origin_file, mode='r', encoding="UTF-8") as rf,
                  open(target_file, mode='w', encoding="UTF-8") as wt):
                for li in rf.readlines():
                    wt.write(li)  # Just copy and paste to the file

        else:
            with open(origin_file, mode='r', encoding="UTF-8") as rf:
                with open(target_file, mode='w', encoding="UTF-8") as wt:
                    cd = current_directive # to pass style check
                    english_origin, english_target = check_english(cd)
                    for line in rf.readlines():
                        new_line = []
                        words = line.split(' ')
                        for wd in words:
                            # Keeping "wd" intact, untouched
                            check = copy.deepcopy(wd)
                            if english_origin:
                                search = check.strip().lower()
                                if search in dictionary:
                                    # to pass style check
                                    rp = dictionary.get(search)
                                    wd = wd.replace(search, rp)
                                    new_line.append(wd)
                                else:
                                    new_line.append(wd)
                            else:
                                search = check.strip()
                                if search in dictionary:
                                    rp = dictionary.get(search)
                                    wd = wd.replace(search, rp)
                                    new_line.append(wd)
                                else:
                                    new_line.append(wd)
                        try:
                            if (new_line[0].strip())[0].isalpha():
                                (new_line[0].strip())[0].upper()
                        except IndexError:
                            pass

                        final_string = ' '.join(new_line)
                        wt.write(final_string)
    except FileNotFoundError:
        pass


def directives_start_processing(directives, metadata, association):
    """
        Function: directives_start_processing()
            iterate through the given directives file
            build temporary dictionary
            and start translation and output
        Parameters:
            directives — list — a list of directives
            metadata — list — containing names of what each element
                    in association's elements are
            association — list — contains multiple lists
                which contain translatable language/emojis
        Returns: None
    """

    num_directives = len(directives)
    for i in range(num_directives):
        current_directive = directives[i]

        temp_dict = build_temp_dict(current_directive, metadata, association)

        do_translation(current_directive, temp_dict)


def extract_dictionary_source(emoji_file_path: str):
    """
        Function: extract_dictionary_source()
            Take the source language to/back to emoji/kamoji info table
            and build associative lists
        Parameters:
            emoji_file_path — str — the path to the file
        Returns - tuple — (metadata, association)
                the metadata and translation guidelines
        Exceptions:
            FileNotFoundError: If no emoji file, a message is printed
    """
    metadata, association = [], []
    try:
        with open(emoji_file_path, mode='r', encoding="UTF-8") as efn_raw:
            # Iterate over the whole projection file
            for line in efn_raw:
                # flag keeps track of whether current line is metadata line
                flag = False
                # strip away all spaces and tabs
                words = line.split()
                for wd in words:
                    stripped = copy.deepcopy(wd)
                    stripped = stripped.strip().upper()
                    if stripped == "METADATA":
                        words.remove(wd)
                        flag = True
                    else:
                        continue
                if flag:
                    for wd in words:
                        metadata.append(wd.upper())
                else:
                    association.append(words)
    except FileNotFoundError:
        print("Attempting to prep dictionary but file not found."
              " Name: " + emoji_file_path)
        pass
    return metadata, association


def batch_translate(emoji_file_name: str, directives_file_name: str):
    """
        Function: batch_translate()
            Main Driver that takes two files and orchestrate all
            other components necessary for translating back and forth
            between language and emoji dialects
        Parameters:
            emoji_file_name — str — file of how to translate
            directives_file_name — str — file of translations to do
        Returns: None
        Exceptions:
            FileNotFoundError: other errors are caught by helper functions
                so if this is caught then some special error has happened
    """
    try:
        metadata, association = extract_dictionary_source(emoji_file_name)

        directives_text = process_directives(directives_file_name)

        directives_start_processing(directives_text, metadata, association)
    except FileNotFoundError:
        print("File not found.")


# batch_translate("emojis.txt", "emoji_directives.txt")
