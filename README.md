
# UsefulThreads for Java

this library currently doesn't work because admittedly, I am still too stupid to work with the OOP paradigm. the plan was to create a Multi-Threading library that you can work with easily.

#### these classes are useful for image processing, string processing and idk extra stuff i guess.

## API Reference

## ThreadSplitter

the ThreadSplitter class consists of 4 important functionalities.

##### __ThreadSplitter__ - _(the main class accepting an arguement of amount of threads you want)_

##### __Worker<T>__ - _(an extensible class for your runnable logic (abstraction of the runnable interface) with 2 overidable methods)_

### ThreadSplitter

#### ThreadSplitter(int threadCount)
self explanatory

#### start(Worker<T> worker, int length) 
length accepts length of the batch being processed, while worker is the logic implementation of how that batch is being processed

### Worker

#### @Override info()
idk this is buggy it doesnt work but supposedly this is where you hoist information (idk how to make that work yet)
#### @Override toRun(int start, int end) 
your logic lies here

