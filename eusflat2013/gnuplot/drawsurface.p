###############################################
# GNU plot script for drawing the surface of an UTI
# Jose Enrique Pons
# jpons@decsai.ugr.es
# #############################################


######
#
# PARAMETERS: ts1, ts, ts2, te1, te, te2
# Where:
#
# ts1 is ts^-
# ts is ts
# ts2 is ts^+
# te1 is te^-
# te is te
# te2 is te^+


ts1 = $0
ts = $1
ts2 = $2

te1 = $3
te = $4
te2 = $5

###
#
# Function that computes the coordinates in the tm for a point (x,y)
# 
#
tmx(x,y) = (x+y)/2
tmy(x,y) = (y-x)/2

#
# Get objects number
#
if (!exists("object_number")) object_number = 1;

#
# Declare a function for object numbers
#
object_num(i,j,k,l) = l+100 + (1000*k) + (100000*j)+(10000000*i)
#
#now we define the two triangular membership functions:
# s(x) for the starting point
# e(x) for the ending point

s(x) = x == ts ? 1 : x >= ts1 && x < ts ? (x-ts1)/(ts - ts1) : x>= ts && x<= ts2 ? (ts2 - x ) / (ts2 - ts) : 0
e(x) = x == te ? 1 : x >= te1 && x < te ? (x-te1)/(te - te1) : x>= te && x<= te2 ? (te2 - x ) / (te2 - te) : 0

#
# and now we define mu_I
#
mui(a,b) = s(a) < e(b) ? s(a): e(b)

#
# the function to compute the color or the gradient is this:
#
gradient(a,b) = sprintf("#%02X%02X%02X",255-255*mui(a,b),255-255*mui(a,b),255-255*mui(a,b))


# for [j=te1:te2]

precision = 0.1


set for [i=(ts1+0.5):(ts2-1)] \
	for [j=(te1+0.5):(te2-1)] \
		for[k=0:9] \
			for [l=0:9] \
		object object_num(i,j,k,l) circle at tmx(i+precision*k,j+precision*l),tmy(i+precision*k,j+precision*l) \
		size 0.04 fc rgb gradient(i+precision*k,j+precision*l) fillstyle solid noborder lw 0


#do for [i=ts1:ts2] {
#	do for [j=te1:te2]{
#		do for [k=0:10] {
#			set object object_number circle  attmx(i*precision*k,j*precision*k),tmy(i*precision*k,j*precision*k) \
#				 size 0.05 fc rgb '#000000' fillstyle solid noborder lw 0
#			#object_number = object_number+1
#
#		}
#	}
#}


 #object 1 circle at 10,10 size 0.01 fc rgb '#000000' fillstyle solid noborder lw 0




