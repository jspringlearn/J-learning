package com.stu.software.feedback.service;
import com.stu.software.feedback.domain.Ctype;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import com.stu.software.feedback.domain.Comment;

import com.stu.software.service.GenericGenerator;
public class FeedbackEntityGenerator extends GenericGenerator {

    @Autowired
    CommentManager commentManager;
    @Autowired
    CtypeManager ctypeManager;


    @Test
    public void gen_ctype() {
        for (int i = 0; i < 4; i++) {
            Ctype g = new Ctype();
            g.setCtypeName("ctype_" + i);
            this.ctypeManager.save(g);
            for (int j = 0; j < 4; j++) {
                Ctype ctype = new Ctype();
                ctype.setCtypeName("ctype_" + i + "_" + j);
                ctype.setParent(g);
                g = this.ctypeManager.save(ctype);
                this.gen_comment(g);
            }
        }
    }

    public void gen_comment(Ctype g) {
        for (int i = 0; i < 10; i++) {
            Comment u = new Comment();
            u.setCommentID("comment_" + i);

            this.commentManager.save(u);
        }
    }

}




