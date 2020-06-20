package quiz.app.questions.professional.exams.adapters

//class QuestionAdapter(val context: Context, private val hobbies: List<Question>) : RecyclerView.Adapter<QuestionAdapter.MyViewHolder>() {
//
//    companion object {
//        val TAG: String = QuestionAdapter::class.java.simpleName
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
//        return MyViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return hobbies.size
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val hobby = hobbies[position]
//        holder.setData(hobby, position)
//    }
//
//    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        var currentHobby: Question? = null
//        var currentPosition: Int = 0
//
//        init {
//            itemView.setOnClickListener {
//                currentHobby?.let {
//                    context.showToast(currentHobby!!.title + " Clicked !")
//                }
//            }
//
//            itemView.imgShare.setOnClickListener {
//
//                currentHobby?.let {
//                    val message: String = "My hobby is: " + currentHobby!!.title
//
//                    val intent = Intent()
//                    intent.action = Intent.ACTION_SEND
//                    intent.putExtra(Intent.EXTRA_TEXT, message)
//                    intent.type = "text/plain"
//
//                    context.startActivity(Intent.createChooser(intent, "Please select app: "))
//                }
//            }
//        }
//
//        fun setData(hobby: Question?, pos: Int) {
//            hobby?.let {
//                itemView.txvTitle.text = hobby.title
//            }
//
//            this.currentHobby = hobby
//            this.currentPosition = pos
//        }
//    }
//}