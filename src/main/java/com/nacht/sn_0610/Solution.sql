select *, if(x + y > z and x + z > y and z + y > x, 'Yes', 'No') as triangle
from triangle