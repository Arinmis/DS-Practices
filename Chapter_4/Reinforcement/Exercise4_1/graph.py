import matplotlib.pyplot as plt
import numpy as np
import math

x_values = []
for x in range(6):
    x_values.append(10 ** x)

def eightN():
    arr = []
    for x in x_values:
        arr.append(8 * x)
    return arr

def n_log_n():
    arr = []
    for x in x_values:
        value = 4 * x * math.log(x)
        arr.append(value)
    return arr

def n_square():
    arr = []
    for x in x_values:
        value =  2 * (x ** 2)
        arr.append(value)
    return arr

def n_cube():
    arr = []
    for x in x_values:
        value =  (x ** 3)
        arr.append(value)
    return arr

def n_power_two():
    arr = []
   
    value =  2 ** 0
    arr.append(value)
    
    value =  2 ** 10 ** 1
    arr.append(value)
        
    for x in range(4): # to equlaize num of data
        value =  2 ** 10 ** 2
        arr.append(value)
    
    
    return arr



func1 = eightN()
func2 = n_log_n()
func3 = n_square()
func4 = n_cube()
func5 = n_power_two()


# plotting function data's
#configure scale
plt.yscale('log')
plt.xscale('log')

#plot fuctions
plt.plot(x_values, func1, label="8n", marker=".", linestyle="--" )
plt.plot(x_values, func2, label="4n logn", marker=".", linestyle="--")
plt.plot(x_values, func3, label="2n^2", marker=".", linestyle="--")
plt.plot(x_values, func4, label="n^3", marker=".", linestyle="--")
plt.plot(x_values, func5, label="2^n", marker=".", linestyle="--")


#axis labels
plt.ylim(top=10 ** 19)
plt.xlabel("n")
plt.ylabel("f(n)")

#sho the plot
plt.legend()
plt.show()