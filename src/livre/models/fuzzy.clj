; --------------------------------------------------- 
; Fuzzy Engineering, "Computing in Fuzzy Cubes", Kosko
; --------------------------------------------------- 
; # The First Theorem: Addition as Fuzzy Mutual Entropy
; 
; Any sum of real numbers x_1,...,x_n equals the fuzzy mutual entropy of fuzzy set F in the unit hypercube [0,1]^n:
;
;       sum_i=1,n x_i = H(F/F^c) - H(F^c/F)                                                                 12.1
;
; where F^c is the fuzzy set complement of F in the unit hypercube I^n. If we add two numbers then F and F^c lie in the
; unit square I^2. If we add three numbers then they lie in I^3 and so on up. 
;
; The proof of 12.1 maps the extended real space Rbar^n = [-\infinity, \infinity] diffeomorphically onto the embedded
; unit hypercube I^n. The proof views the real numbers x_1,...,x_n as the components of the real vector x in Rbar^n and
; maps x to a unique point or fuzzy set F in the fuzzy space I^n. 
;
; The mutual entropy terms H(F/F^c) and H(F^c/F) stem from the logarithm of the fuzziness of F. As discussed below this
; fuzziness depends on how much F resembles its complement fuzzy set F^c. In this sense we can replace the two H terms
; in 12.1 with an entropy operator \ScriptH applied to fuzzy set F:
;
;       sum_i=1,n x_i = \ScriptH(F)                                                                     12.2
;
; The operator \ScriptH replaces each sum with the value of a map from fuzzy sets to real numbers...
;
;
;
;
; # Fuzzy Sets as points in Hypercubes: Degrees of Subsethood
;
; Multivalence or "fuzziness" holds in sets and between sets. Fuzziness ina  set defines elementhood or the degree a_i
; to which element x_i belongs to set A: a_i = Degree(x_i \in A). A standard or bivalent or nonfuzzy set A contains
; elements all or none. The set value or membership degree a_i is 1 or 0, present or absent, in or out. A multivalent
; set contains elements to some degree. So a_i takes values in the unit interval [0,1]. Black called this multivalence
; "vagueness" and intorduced vague sets or vague lists. Zadeh called tehse vague or multivalued sets "fuzzy" sets and
; worked out their algebra.
;
; Fuzziness between sets defines subsethood or the degree S(A, B) to which set A belongs to or is a subset of set B:
; S(A, B) = Degree(A \subset B). The sets A and B need not be fuzzy. If a fuzzy set A contains an element x_i to degree
; a_i then S({x_i}, A) = a_i. So subsethood subsumes elementhood. In the past the subsethood operator S has defined a
; bivalent operator in both fuzzy and nonfuzzy set theory: S(A, B) = 0 or 1. The multivalued subsethood operator can
; also assume the values  0 < S(A,B) < 1. 
;
; The subsethood operator arises from the unique l^p extension of the Pythagorean theorem in n dimensions:
;
;         ||A - B||^p = ||A - B*||^p + ||B* - B||^p                                 12.3
;
; for p>= 1, n-vectors A, B, and B*, and with the norm
;         
;         ||A||^p = sum(1,n) |a_i|^p. 
;
; The usual Pythagorean theorem holds if p = 2. For any p there are at least 2^n vectors or sets B* that satisfy 12.3.
; For p> 1 there are only 2^n such sets B* and b*_i = a_i or b*_i = b_i. For fuzzy sets these 2^n choices of picking any
; vertex of the unit hypercube I^n as the origin or empty set. Once picked then b*_i = min(a_i, b_i). If A and B are bit
; vectors or regular nonfuzzy subsets of finite space X = {x_i,...,x_n} then this implies B* equals (intersect A B). The
; same holds for fuzzy subsets A and B or X:
;
;                 B* = intersect A B
;
;
; Suppose set or space X is finite with X = {x_1,...,x_n}. Then the 2^n nonfuzzy subsets of X map to the 2^n bit vectors
; of length n. These map in turn to the 2^n corners of the unit hypercube I^n. This equates a set with a point in the
; Boolean n-lattice. We can also view fuzzy subsets of X as n-vectors with components in [0,1]. Then each vector
; component a_i of fuzzy set A = (a_1,...,a_n) defines a fuzzy unit or fit and A defines a fit vector. The set function
; a:X->[0,1] defines the n fit values a(x_1),...,a(x_n) for a finite space X and so gives the fit vector A =
; (a_1,...,a_n) for a_i = a(x_i). Fit value a_i measures the degree to which element x_i belongs to or fits in set A.
; This identifies A with a point on or in the unit hypercube I^n. Fuzzy sets fill in the Boolean n-cube to give the
; solid hypercube I^n. The midpoint of the unit cube is the fit vector F = (1/2,...,1/2) where each element x_i belongs
; to F as much as it belongs to its complement F^c. The usual set operations apply to fit vectors as Zadeh proposed for
; fuzzy set functions:
;
;   (intersect A B) => (min(a_1,b_1),...,min(a_n,b_n))
;   (union A B) => (max(a_1,b_1),...,max(a_n,b_n))
;   (complement A) => (1-a_1,...,1-a_n)
;   ...
;
; Note that (intersect A A^c) =/= {} and (union A A^c) =/= X for all fuzzy sets A. Aristotle's bivalent "laws" of
; noncontradiction and excluded middle no longer hold. They hold only to some degree. They hold 100% only for the bit
; vectors at cube vertices. They hold 0% at the cube midpoint when A = A^c. They hold only to some degree for fit
; vectors between these extremes. The next section shows how the overlap term (intersect A A^c) and underlap term (union
; A A^c) give a unique measure of the fuzziness or entropy of A. 
;
; If A and B are not fuzzy sets then the 100% subsethood relation A \sub B holds if and only if (<= a_i b_i) for all i.
; It still holds if A and B are fuzzy sets: S(A, B) = 1 iff (<= a_i b_i). Then all of B's 100% subsets define a
; hyperrectagle in I^n with long diagonal that runs from the origin to point B. S(A, B) = 1 iff A lies in or on this
; hyperrectangle and thus iff A lies in the fuzzy power set of B: A \in F(2^B). S(A, B) < 1 iff A lies outside the
; hyperrectangle. The closer A lies to the hyperrectangle then the larger the value S(A, B). The minimum distance lies
; between A and B* [where] B* is the 100% subset of B closes to A in any l^p metric. This distance gives the l^p
; "orthogonal" projection of A onto F(2^B)...
;
; ...let c(A) denote the count or cardinality of A:
;
;   c(A) = a_1 + a_2 + ... + a_n
;        = |a_1 - 0| + ... + |a_n - 0|
;        = l^n( #{}, A).
;
; [These equalities] geometrize the count c(A) as the l^1 or fuzzy Hamming distance between A and the origin or empty
; set #{}. The count extends the clasical counting measure of combinatorics to fuzzy sets: c(A) equals the counting
; measure of A on nonfuzzy sets A. It gives the number of elements in A if A is finite and gives \infinity if A is
; infinite -- if A maps one-to-one to one of its proper subsets. The subsethood measure S(A, B) depends on the minimal
; distance d(A, B*). In the fuzzy Hamming metric this means S(A, B) = 1 - (l^1(A, B*)/f(A)). The boundary condition S(A,
; #{}) = 0 if A =/= #{} shows that f(A) = c(A)....
;
; [anyway,] This gives the subsethood theorem:
;
;       S(A, B) = (cardinality (intersect A B)) / (cardinality A)                                 (12.9)
;
; If A = (1/3 3/4) and B = (1/2 1/3) then S(A, B) = 2/3 / 13/12 = 8/13 and S(B, A) = 2/3 / 5/6 = 4/5. So B is more a
; subset of A than A is of B. 
;
; The derived ratio in (12.9) has the same form as the conditional probability P(B|A). We can view the event probability
; P(A) as the degree to which the sample space X is a subset of its own subset or event A: P(A) = S(X, A) for some
; measure S of subsethood. This reflects the standard identity P(A) = P(A|X). 
;
; The subsethood theorem...also implies that the whole-in-the-part term S(X, A) gives the relative frequency n_a/n if A
; denotes a bit vector with n_A 1s or successes and with n - n_A 0s or failures:
;
;         S(X, A) = card (intersect A X) / card X = card A / card X = n_a/n.
;
; This too confirms the relation S(X, A) = P(A|X). In general S(X, A) = c(A)/n or c(A) = n S(X, A). So even the counting
; measure c(A) reduces to subsethood. Subsethood depends in turn only on the metrical structure of fuzzy cubes. 
;
; The subsethood theorem (12.9) also implies S({x_i}, A) = a_i. This holds since the singleton set {x_i} maps to the
; unit bit vector (0 ... 0 1 0 ... 0) with a 1 in the ith slot and 0s elsewhere and since A = (a_1,...,a_n). Then
; c({x_i}) = 1 and c(intersect {x_i} A) = a_i. So S({x_i},A) = a_i and subsethood formally subsumes elementhood. 
;
; Maps between unit cubes define the simplest fuzzy systems S:I^n -> I^p. These fuzzy systems associate output fuzzy
; sets with input fuzzy sets and so generalize if-then rules. We saw in Chapter 2 that general fuzzy systems F: R^n ->
; R^p are uniformly dense in the space of continuous functions: A fuzzy system can approximate any real continuous (or
; bounded Borel measureable) function on a compact set to any degree of accuracy. The fuzzy system contains m fuzzy
; rules of the form if X = A then Y = B that associate a then-part fuzzy set B with an if-part fuzzy set A. We also saw
; in Chapter 2 that a rule defines a fuzzy cartesian product A x B or patch in the input-output state space X x Y. A
; fuzzy system approximates a function by covering its graph with patches and averaging patches that overlap. All the
; rules fire to some degree as in a neural associative memory. The fuzzy approximation theorem shows that finite
; discretizations of A and B suffice for the covering. So the patch or fuzzy Cartesian product A x B can reduce to a
; fuzzy r-by-s matrix M or relation or point in I^(rs). Then M defines the system mapping M: I^r -> I^s and the
; subsethood measure in (12.9) applies to M. In the same product space each fuzzy system is a subset to some degree of
; all other fuzzy systems. Then (12.11) below shows that each fuzzy system has a unique numerical measure of fuzziness
; or entropy. 
;
; # Fuzziness and Entropy
;
; The fuzziness of a fuzzy set answers a basic question: How fuzzy is a fuzzy set? A nonfuzzy set lies at a vertex of
; cube I^n and has 0% fuzziness. The cube midpoint M equals its own opposite (M = M^c) and it alone has 100% fuzziness.
; In between it varies. The fuzziness of set F grows as the distance falls between F and F^c and thus as F and F^c lie
; closer to the midpoint M. 
;
; This cube geometry motivates the ratio measure of fuzziness E(F) = a/b. Here a is the distance l^1(F, F_near) from F to
; the nearest vertex F_near and b is the distance l^1(F, F_far). A long diagonal connects F_near to F_far. The fuzzy
; entropy theorem reduces this ratio of distances to a ratio of counts:
;
;     E(F) = c(intersect F F^c)/c(union F F^c).                                                 12.10
;
; If F = (1/3 3/4) then E(F) = 7/12 / 17/12 = 7/17...
;
; The fuzzy entropy theorem (12.10) shows that the fuzziness of fuzzy set F depends on how much its overlap (intersect F
; F^C) and underlap (union F F^c) break Aristotle's laws of noncontradiction and excluded middle. The underlap always
; fully contains the overlap: S(intersect F F^C, union F F^c) - 1. So we might expcet E(F) to involve subsethood in the
; converse direction S(union F F^c, intersect F F^c) when the part partially contains the whole. In fact 12.9 and 12.10
; reduce fuzziness to subsethood:
;
;       E(F) = S(union F F^c, intersect F F^c)                                                12.11
;
;
; The next chapter shows that a measure of mutual subsethood or fuzzy equivalence has the form \Epsilon(A,B) = c(A \int
; B)/c(A \union B). This theorem and 12.10 then give back the fuzziness of A as the degree to which A equals A^c: E(A) =
; \Epsilon(A, A^c).
;
; The probabilistic entropy H(P) holds for fit vectors on the simplex in I^n. Then
;     
;     H(P) = sum_i=1,n p_i log (1/p_i)                                            12.12
;
; and c(P) = p_1 + ... + p_n = 1. The fuzziness measure E(P) differs from H(P) for the same P. If no p_j > 1/2 then E(P)
; 1/(n-1) and so E(P) falls to zero as the cube dimension n grows to infinity. The uniform set (1/n, ... ,1/n) belongs
; to this set of P vectors along with ncountably many others. If some p_j > 1/2 then E(P) < 1/(n-1). So the uniform set
; maximizes E(P) but does not uniquely maximize it. So E differs from H.
;
; Now consider how E resembles H. Consider the probability element p_i and the motivation for the logarithm measure
; (12.12) as the average information or entropy of a message or event: "Information is inversely related to the
; probability of occurrence". The more improbable the event then the more informative the event if the event occurs. So
; information increases with 1/p_i. The same intuition holds for monotone-increasing transforms of 1/p_i. This includes
; the logarithmic transform log 1/p_i and only the logarithmic transform in the additive case. The weighted average over
; the system or alphabet gives the entropy as the expected information (12.12)
;
; In the one-fit case E(F) reduces to f/(1-f) if f <= 1/2 and to (1-f)/f if f >= 1/2. This ratio grows to 1 as f moves
; to the midpoint 1/2 and falls to 0 as f moves to 0 or 1. The more vague or fuzzy the event then the more informative
; the event if it occurs. The operator E is subadditive on fuzzy sets since in a fuzzy space all events connect to one
; another to some degree. Integration also shows that f/(1-f) and (1-f)/f define a continuous probability density on
; [0,1] if we normalize the integral by ln 4 - 1 (which has power series
;
;       sum_n-1,\infinity \frac{(-1)^(n+1)}{n(n+1)}).
;
; Note that the unit fuzziness f/(1-f) is the fundamental power series of a fit value f:
;
;       f/(1-f) = sum_n=1,\infinity f^n for f < 1.
;
; So far we have only reviewed fuzzy entropy. We now extend it to mutual entropy to set up the proof of the first
; theorem.
;
;
; # Fuzzy Mutual Entropy
;
; Fuzzy mutual entropy arises from a natural question: Why not take the logarithm of the unit fuzziness f/(1-f)? Any
; monotone transform will preserve its shape. So why not follow the probability examples and use a logarithm? Then we
; can weigh the log terms with the fit values and get a more proper measure of the entropy of a fuzzy set. The idea is
; to replace the intuition chain
;
;     p_i -> 1/p_i -> ln 1/p_i -> sum_i p_i ln 1/p_i                        12.13
;
; with the new fuzzy chain
;
;     f_i -> f_i/(1-f_i) -> ln f_i/(1-f_i) -> sum_i (f_i ln f_i/(1-f_i)).      12.14
;
; The new fuzzy entropy term in 12.14 uses the natural logarithm to simplify the proof of the main theorem. The sum term
; defines a fuzzy mutual entropy. 
;
; For probability vectors P and Q in the I^n simplex define the mutual entropy H(P/Q) of P given Q as
;
;         H(P/Q) = sum_i p_i ln p_i/q_i.                                                              12.15
;
; The mutual entropy measures distance in the simplex in the rough sense that H(P/Q) = 0 if P = Q and H(P/Q) > 0 if P
; =/= Q. This follows from the Gibbs inequality. Some stochastic learning automata and neural networks minimize H(P/Q)
; as the learning system's distribution P tries to estimate the distribution Q of the sampled environment. In the cube
; I^n the fuzzy mutual entropy term in 12.14 is the usual mutual entropy H(F/F^c) defined on fit vectors. 
;
; The sum of the fuzzy information units ln f_i/(1-f_i) splits into the mutual entropies of fuzzy sets F and F^c:
;
;       Lemma:
;       sum_i=1,n ln f_i/(1-f_i) = H(F/F^c) - H(F^c/F)  
;
;       [proof omitted, but its on page 412]
;
; The fuzziness measure in 12.10 shows that E(F) = E(F^c). This reflects the 2-fold symmetry of the fuzzy cube I^n. But
; the mutual entropy operator is asymmetric. H(F/F^c) = H(F^c/F) if F = F^c and thus if F and F^c lie at the cube
; midpoint. The mutual entropy summands grow to infinity or zero as F and F^c move to cube vertices. 
;
; # The Proof: Diffeomaps between Real Spaces and Fuzzy Cubes
;
; Fuzzy cubes map smoothly onto extended real spaces of the same dimension and vice versa. The 2^n infinite limits of
; extended real space [-\infinity, \infinity]^n map to the 2^n binary corners of the fuzzy cube I^n. The real origin 0
; maps to the cube midpoint. Each real point x maps to a unique fuzzy set F... 
;
; A diffeomorphism f: Rbar^n -> I^n is a one-to-one and onto differentiable map f with a differentiable inverse f^(-1).
; Other diffeomaps can reveal other fuzzy structure of operations in real space. The theorem 12.1 follows from the
; choice of one of the simplest diffeomaps. We pick the logistic map used in neural models to convert an unbounded real
; input x_i to a bounded signal or fit value f_i:
;
;       f_i = 1/(1 + e^(-x_i)).                                               12.20
;
; In extended real space Rbar^n the logistic map applies to each term of vector x = (x_1,...,x_n). Note that f_i = 0 iff
; i_x = -\infinity, f_i = 1 iff x_i = \infinity, and f_i = 1/2 iff x_i = 0. Each real x picks out unique dual fuzzy sets
; F and F^c in fuzzy space. 
;
; The proof of 12.1 follows from the lemma...and from the inverse of the logistic map 12.20:
;
;     x_i = f^(-1)(f_i) = ln f_i/(1-f_i)          12.21
;
; So each real number is a unit of fuzzy information 12.14. This is just the logarithm of the scalar measure of
; fuzziness 12.10. We sum over all vector components x_i and apply the lemma to prove 12.1 and 12.2:
;
;
;       sum_i=1,n x_i = H(F/F^c) - H(F^c/F) = \ScriptH(F) in operator notation. 
;
;
;       [cut the direct proof for each term on p413]
;
; =================================================== =================================================== 
;
; Next: Information Fields, Shannon Entropy from Fuzzy Mutual Entropy, Field Equations, Information Fluids!
