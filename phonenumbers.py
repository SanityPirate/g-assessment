import os
import re

# regex matches phone numbers with formats xxx-xxx-xxxx or (xxx) xxx-xxxx
r = re.compile("([(][0-9]{3}[)][ ][0-9]{3}[-][0-9]{4})|([0-9]{3}[-][0-9]{3}[-][0-9]{4})")

directory = "website"
filetype = ".html"
f = open("phone_numbers.txt", "w")


for filename in os.listdir(directory):
    if filename.endswith(filetype):
        with open(directory + "/" + filename, 'r') as file:
            if re.search(r, file.read()):
                # if the file contains a phone number, write its path to a text file.
                f.write(file.name + "\n")

f.close()
