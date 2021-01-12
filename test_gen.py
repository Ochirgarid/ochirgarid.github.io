import random
import string

sample = "".join(random.choices(string.ascii_lowercase, k=100))
print(sample)